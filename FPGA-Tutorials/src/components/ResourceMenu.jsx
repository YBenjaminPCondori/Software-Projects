import { ExternalLinkIcon } from './Icons.jsx'
import { resourceGroups } from '../data/navigation.js'

function ResourceLink({ link, onNavigate }) {
  return (
    <a
      className={`resource-link ${link.current ? 'resource-link-current' : ''}`}
      href={link.href}
      target="_blank"
      rel="noreferrer"
      onClick={onNavigate}
    >
      <span>{link.label}</span>
      {link.current && <span className="sr-only"> (current article)</span>}
      <ExternalLinkIcon className="size-3.5 shrink-0 opacity-55" />
    </a>
  )
}

export default function ResourceMenu({ mobile = false, onNavigate }) {
  if (mobile) {
    return (
      <div className="space-y-2">
        {resourceGroups.map((group, index) => (
          <details key={group.label} className="group rounded-xl border border-line bg-white" open={index === 4}>
            <summary className="flex cursor-pointer list-none items-center justify-between px-4 py-3 font-semibold text-ink">
              {group.label}
              <span className="text-coral transition-transform group-open:rotate-45">+</span>
            </summary>
            <div className="border-t border-line px-3 py-2">
              <ResourceLink link={{ label: `${group.label} overview`, href: group.href }} onNavigate={onNavigate} />
              {group.links.map((link) => <ResourceLink key={link.href} link={link} onNavigate={onNavigate} />)}
            </div>
          </details>
        ))}
      </div>
    )
  }

  return (
    <div className="mx-auto grid max-w-[1360px] gap-x-8 gap-y-8 px-8 py-8 lg:grid-cols-5 xl:px-12">
      {resourceGroups.map((group) => (
        <section key={group.label} aria-labelledby={`resource-${group.label.replaceAll(' ', '-').toLowerCase()}`}>
          <a
            id={`resource-${group.label.replaceAll(' ', '-').toLowerCase()}`}
            className="mb-3 inline-flex items-center gap-2 font-bold text-ink hover:text-coral"
            href={group.href}
            target="_blank"
            rel="noreferrer"
            onClick={onNavigate}
          >
            {group.label}
            <ExternalLinkIcon className="size-3.5" />
          </a>
          <div className="space-y-0.5">
            {group.links.map((link) => <ResourceLink key={link.href} link={link} onNavigate={onNavigate} />)}
          </div>
        </section>
      ))}
    </div>
  )
}
