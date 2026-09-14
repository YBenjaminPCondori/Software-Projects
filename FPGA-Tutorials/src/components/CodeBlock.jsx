import { useState } from 'react'
import { CopyIcon } from './Icons.jsx'

export default function CodeBlock({ title, code, compact = false }) {
  const [copied, setCopied] = useState(false)

  const copyCode = async () => {
    try {
      if (navigator.clipboard?.writeText) {
        await navigator.clipboard.writeText(code)
      } else {
        throw new Error('Clipboard API unavailable')
      }
      setCopied(true)
      window.setTimeout(() => setCopied(false), 1800)
    } catch {
      const textarea = document.createElement('textarea')
      textarea.value = code
      textarea.setAttribute('readonly', '')
      textarea.style.position = 'fixed'
      textarea.style.opacity = '0'
      document.body.appendChild(textarea)
      textarea.select()
      const copiedWithFallback = document.execCommand('copy')
      textarea.remove()
      setCopied(copiedWithFallback)
      if (copiedWithFallback) window.setTimeout(() => setCopied(false), 1800)
    }
  }

  return (
    <div className="overflow-hidden rounded-xl border border-code-border bg-code shadow-code">
      <div className="flex items-center justify-between gap-4 border-b border-white/10 px-4 py-3 sm:px-5">
        <p className="truncate font-mono text-xs font-semibold uppercase tracking-[0.12em] text-code-muted">{title}</p>
        <button
          type="button"
          className="inline-flex items-center gap-2 rounded-md px-2 py-1 font-mono text-xs text-code-muted transition-colors hover:bg-white/10 hover:text-white focus-ring-dark"
          onClick={copyCode}
          aria-live="polite"
        >
          <CopyIcon />
          {copied ? 'Copied' : 'Copy'}
        </button>
      </div>
      <pre className={`code-scroll ${compact ? 'max-h-72' : 'max-h-[34rem]'}`} tabIndex="0"><code>{code}</code></pre>
    </div>
  )
}
