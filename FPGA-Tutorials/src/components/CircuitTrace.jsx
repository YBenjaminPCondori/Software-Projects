export default function CircuitTrace({ className = '', side = 'right' }) {
  const mirrored = side === 'left' ? '-scale-x-100' : ''

  return (
    <svg
      className={`pointer-events-none absolute text-trace ${mirrored} ${className}`}
      viewBox="0 0 520 360"
      fill="none"
      aria-hidden="true"
    >
      <path d="M519 34H412c-21 0-24 26-46 26h-78M519 82H383c-23 0-24 27-48 27h-98M519 144H444c-30 0-27 38-58 38H255c-26 0-24 33-49 33H81" stroke="currentColor" />
      <path d="M519 243H412c-22 0-26-31-49-31H238c-23 0-24 26-47 26H66M519 310H382c-28 0-25-34-52-34H188c-26 0-24-29-50-29H0" stroke="currentColor" strokeDasharray="5 5" />
      <path d="M429 82V25M335 109V151M206 215V268M81 215V178M382 310v42" stroke="currentColor" />
      <path d="M518 144h-10M519 243h-10" stroke="#f0522d" strokeWidth="2" />
      <circle cx="429" cy="24" r="5" fill="white" stroke="currentColor" />
      <circle cx="335" cy="156" r="5" fill="white" stroke="currentColor" />
      <circle cx="206" cy="273" r="5" fill="white" stroke="#f0522d" />
      <circle cx="81" cy="173" r="5" fill="white" stroke="currentColor" />
      <rect x="280" y="55" width="8" height="8" fill="white" stroke="currentColor" />
      <rect x="233" y="104" width="8" height="8" fill="white" stroke="currentColor" />
      <rect x="63" y="234" width="8" height="8" fill="white" stroke="currentColor" />
      <rect x="378" y="348" width="8" height="8" fill="white" stroke="currentColor" />
    </svg>
  )
}
