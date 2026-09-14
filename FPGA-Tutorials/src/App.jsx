import { useEffect } from 'react'
import Footer from './components/Footer.jsx'
import Hero from './components/Hero.jsx'
import Implementation from './components/Implementation.jsx'
import Navbar from './components/Navbar.jsx'
import ProgrammingTricks from './components/ProgrammingTricks.jsx'

export default function App() {
  useEffect(() => {
    if (!window.location.hash) return
    const frame = window.requestAnimationFrame(() => {
      document.querySelector(window.location.hash)?.scrollIntoView()
    })
    return () => window.cancelAnimationFrame(frame)
  }, [])

  return (
    <>
      <Navbar />
      <main id="main-content">
        <Hero />
        <ProgrammingTricks />
        <Implementation />
      </main>
      <Footer />
    </>
  )
}
