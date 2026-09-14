import CircuitTrace from './CircuitTrace.jsx'
import { ExternalLinkIcon } from './Icons.jsx'
import { sourceLinks } from '../data/navigation.js'

function ChipDiagram() {
  return (
      <div className="relative mx-auto h-52 w-full max-w-2xl" aria-hidden="true">
      <CircuitTrace className="-left-32 top-0 h-full w-[34rem]" side="left" />
      <CircuitTrace className="-right-32 top-0 h-full w-[34rem]" />
      <div className="absolute left-1/2 top-1/2 grid size-24 -translate-x-1/2 -translate-y-1/2 place-items-center rounded-xl border border-trace bg-white shadow-chip">
        <div className="grid grid-cols-5 gap-1.5">
          {Array.from({ length: 25 }, (_, index) => <i key={index} className="size-1 rounded-full bg-coral" />)}
        </div>
      </div>
    </div>
  )
}

export default function Hero() {
  return (
    <section id="overview" className="relative scroll-mt-24 overflow-hidden border-b border-line bg-white">
      <div className="mx-auto grid max-w-[1440px] gap-14 px-5 pb-16 pt-14 sm:px-8 sm:pt-20 lg:min-h-[760px] lg:grid-cols-[1.18fr_0.82fr] lg:items-center lg:gap-12 lg:px-12 lg:pb-12 lg:pt-16">
        <div className="relative z-10">
          <h1 className="max-w-[780px] text-balance text-[clamp(3rem,5vw,4.75rem)] font-bold leading-[0.99] tracking-[-0.055em] text-ink">
            <span className="lg:block">The first in the</span>{' '}
            <span className="lg:block">history of mankind</span>{' '}
            <span className="lg:block">KAN training on</span>{' '}
            <span className="lg:block">FPGA board</span>
          </h1>
          <div className="mt-5 hidden lg:block">
            <ChipDiagram />
          </div>
        </div>

        <aside className="relative z-10 overflow-hidden rounded-2xl border border-line bg-white shadow-panel" aria-label="Source links">
          <div className="divide-y divide-line px-5 sm:px-8">
            {sourceLinks.map((link) => (
              <a
                key={link.href}
                className="group grid gap-2 py-6 outline-none transition-colors hover:bg-surface focus-visible:bg-coral-soft sm:min-h-[102px] sm:grid-cols-[minmax(150px,0.8fr)_minmax(250px,1.2fr)] sm:items-center sm:px-1"
                href={link.href}
                target="_blank"
                rel="noreferrer"
              >
                <span className="font-medium leading-snug text-ink">{link.label}</span>
                <span className="flex items-center justify-between gap-3 text-left font-semibold leading-snug text-coral sm:text-right">
                  <span className={`sm:ml-auto ${link.title.startsWith('aarushgupta') ? 'text-sm' : ''}`}>{link.title}</span>
                  <ExternalLinkIcon className="size-5 shrink-0 transition-transform group-hover:-translate-y-0.5 group-hover:translate-x-0.5" />
                </span>
              </a>
            ))}
          </div>
        </aside>

        <div className="lg:hidden">
          <ChipDiagram />
        </div>
      </div>
      <CircuitTrace className="-bottom-24 -right-20 hidden h-72 w-[34rem] opacity-60 lg:block" />
    </section>
  )
}
