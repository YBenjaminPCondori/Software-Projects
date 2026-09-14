import Logo from './Logo.jsx'
import { ExternalLinkIcon } from './Icons.jsx'

export default function Footer() {
  return (
    <footer className="relative overflow-hidden border-t border-line bg-white">
      <CircuitLines />
      <div className="relative z-10 mx-auto flex max-w-[1440px] flex-col gap-8 px-5 py-10 sm:px-8 md:flex-row md:items-center md:justify-between lg:px-12">
        <a href="#overview" className="w-fit rounded-md focus-ring"><Logo compact /></a>
        <p className="max-w-xl text-sm leading-6 text-muted">Private local learning rebuild. Original FPGA Debut educational content is preserved.</p>
        <a
          href="http://openkan.org/FPGA_debut.html"
          target="_blank"
          rel="noreferrer"
          className="inline-flex w-fit items-center gap-2 font-semibold text-coral underline-offset-4 hover:underline focus-ring"
        >
          Original page
          <ExternalLinkIcon />
        </a>
      </div>
    </footer>
  )
}

function CircuitLines() {
  return (
    <svg className="pointer-events-none absolute -right-24 bottom-0 h-44 w-[34rem] text-trace opacity-70" viewBox="0 0 520 180" fill="none" aria-hidden="true">
      <path d="M520 36H370c-25 0-25 28-50 28H210M520 86H414c-26 0-28 30-53 30H250M520 142H382c-26 0-27-32-52-32H174" stroke="currentColor" />
      <circle cx="210" cy="64" r="4" fill="white" stroke="currentColor" />
      <rect x="170" y="106" width="8" height="8" fill="white" stroke="#f0522d" />
    </svg>
  )
}
