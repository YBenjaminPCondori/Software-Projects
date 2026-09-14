import { useEffect, useRef, useState } from 'react'
import Logo from './Logo.jsx'
import ResourceMenu from './ResourceMenu.jsx'
import { ChevronIcon, CloseIcon, MenuIcon } from './Icons.jsx'
import { sectionLinks } from '../data/navigation.js'

function useActiveSection() {
  const [active, setActive] = useState('overview')

  useEffect(() => {
    const sections = sectionLinks.map(({ href }) => document.querySelector(href)).filter(Boolean)
    const observer = new IntersectionObserver(
      (entries) => {
        const visible = entries.filter((entry) => entry.isIntersecting).sort((a, b) => b.intersectionRatio - a.intersectionRatio)
        if (visible[0]) setActive(visible[0].target.id)
      },
      { rootMargin: '-20% 0px -65% 0px', threshold: [0, 0.2, 0.5] },
    )
    sections.forEach((section) => observer.observe(section))
    return () => observer.disconnect()
  }, [])

  return active
}

export default function Navbar() {
  const [resourcesOpen, setResourcesOpen] = useState(false)
  const [mobileOpen, setMobileOpen] = useState(false)
  const rootRef = useRef(null)
  const active = useActiveSection()
  const closeMenus = () => {
    setResourcesOpen(false)
    setMobileOpen(false)
  }

  useEffect(() => {
    const onKeyDown = (event) => {
      if (event.key === 'Escape') closeMenus()
    }
    const onPointerDown = (event) => {
      if (resourcesOpen && rootRef.current && !rootRef.current.contains(event.target)) setResourcesOpen(false)
    }
    window.addEventListener('keydown', onKeyDown)
    window.addEventListener('pointerdown', onPointerDown)
    return () => {
      window.removeEventListener('keydown', onKeyDown)
      window.removeEventListener('pointerdown', onPointerDown)
    }
  }, [resourcesOpen])

  useEffect(() => {
    document.body.style.overflow = mobileOpen ? 'hidden' : ''
    return () => { document.body.style.overflow = '' }
  }, [mobileOpen])

  return (
    <header ref={rootRef} className="sticky top-0 z-50 border-b border-line bg-white/95 backdrop-blur-md">
      <nav className="mx-auto flex h-[76px] max-w-[1440px] items-center justify-between px-5 sm:px-8 xl:px-12" aria-label="Primary navigation">
        <a href="#overview" onClick={closeMenus} className="rounded-md focus-ring"><Logo /></a>

        <div className="hidden h-full items-center gap-10 lg:flex">
          {sectionLinks.map((link) => (
            <a
              key={link.href}
              href={link.href}
              className={`nav-link ${active === link.href.slice(1) ? 'nav-link-active' : ''}`}
            >
              {link.label}
            </a>
          ))}
        </div>

        <button
          type="button"
          className="hidden items-center gap-3 rounded-xl border border-coral px-5 py-3 font-semibold text-ink transition-colors hover:bg-coral-soft focus-ring lg:flex"
          aria-expanded={resourcesOpen}
          aria-controls="desktop-resource-menu"
          onClick={() => setResourcesOpen((open) => !open)}
        >
          Explore OpenKAN
          <ChevronIcon className={`size-4 transition-transform ${resourcesOpen ? 'rotate-180' : ''}`} />
        </button>

        <button
          type="button"
          className="grid size-11 place-items-center rounded-xl border border-line text-ink focus-ring lg:hidden"
          aria-label={mobileOpen ? 'Close navigation menu' : 'Open navigation menu'}
          aria-expanded={mobileOpen}
          aria-controls="mobile-menu"
          onClick={() => setMobileOpen((open) => !open)}
        >
          {mobileOpen ? <CloseIcon /> : <MenuIcon />}
        </button>
      </nav>

      {resourcesOpen && (
        <div id="desktop-resource-menu" className="absolute inset-x-0 top-full max-h-[calc(100vh-76px)] overflow-y-auto border-b border-line bg-surface shadow-menu">
          <ResourceMenu onNavigate={closeMenus} />
        </div>
      )}

      {mobileOpen && (
        <div id="mobile-menu" className="absolute inset-x-0 top-full h-[calc(100vh-76px)] overflow-y-auto border-b border-line bg-surface px-5 pb-10 pt-5 lg:hidden">
          <div className="mx-auto max-w-2xl">
            <div className="mb-6 grid gap-2 border-b border-line pb-6">
              {sectionLinks.map((link) => (
                <a key={link.href} href={link.href} onClick={closeMenus} className="rounded-xl px-4 py-3 text-lg font-semibold text-ink hover:bg-white focus-ring">
                  {link.label}
                </a>
              ))}
            </div>
            <p className="mb-3 px-1 text-sm font-bold uppercase tracking-[0.14em] text-muted">Explore OpenKAN</p>
            <ResourceMenu mobile onNavigate={closeMenus} />
          </div>
        </div>
      )}
    </header>
  )
}
