export default function Equation({ label, children, inline = false }) {
  const Tag = inline ? 'span' : 'div'
  return (
    <Tag className={inline ? 'inline-equation' : 'equation'} aria-label={label} role="math">
      <span aria-hidden="true">{children}</span>
    </Tag>
  )
}
