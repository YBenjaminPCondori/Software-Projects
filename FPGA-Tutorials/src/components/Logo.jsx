export default function Logo({ compact = false }) {
  return (
    <span className="inline-flex items-center gap-3 text-ink" aria-label="OpenKAN home">
      <svg className={compact ? 'size-8' : 'size-9'} viewBox="0 0 40 40" fill="none" aria-hidden="true">
        <rect x="8" y="8" width="24" height="24" rx="5" stroke="currentColor" strokeWidth="2.4" />
        <path d="M4 13h4M4 20h4M4 27h4M32 13h4M32 20h4M32 27h4M13 4v4M20 4v4M27 4v4M13 32v4M20 32v4M27 32v4" stroke="currentColor" strokeWidth="2.4" strokeLinecap="square" />
        <path d="M18 8h5M32 18v5M17 32h5M8 17v5" stroke="#f0522d" strokeWidth="3.2" />
      </svg>
      <span className={compact ? 'text-lg font-bold' : 'text-xl font-bold'}>
        Open<span className="text-coral">KAN</span>
      </span>
    </span>
  )
}
