import CircuitTrace from './CircuitTrace.jsx'
import Equation from './Equation.jsx'

function Trick({ number, title, children }) {
  return (
    <article className="trick-row">
      <div className="trick-marker" aria-hidden="true"><span>{number}</span><i /></div>
      <div className="min-w-0 pb-9 pt-1 sm:pb-11">
        <h3 className="text-2xl font-bold tracking-[-0.025em] text-ink sm:text-[1.7rem]">{title}</h3>
        <div className="mt-3 space-y-4 text-[1.02rem] leading-7 text-body sm:text-[1.08rem]">{children}</div>
      </div>
    </article>
  )
}

export default function ProgrammingTricks() {
  return (
    <section id="programming-tricks" className="relative scroll-mt-24 overflow-hidden bg-white py-16 sm:py-24">
      <h2 className="sr-only">Programming tricks</h2>
      <CircuitTrace className="-left-60 top-16 h-[34rem] w-[46rem] opacity-65" side="left" />
      <CircuitTrace className="-right-72 bottom-24 h-[34rem] w-[46rem] opacity-65" />

      <div className="relative z-10 mx-auto max-w-[1160px] px-5 sm:px-8 lg:px-12">
        <div className="trick-list">
          <Trick number="1" title="Programming trick #1">
            <p>Features, targets, model and all intermediate values are integers, data is rescaled, model parameters are arbitrary.</p>
          </Trick>

          <Trick number="2" title="Programming trick #2">
            <p>All functions are piecewise linear with even segments which lengths is power of two. So when we find segment for argument it is not</p>
            <div className="grid gap-3 md:grid-cols-2">
              <Equation label="N equals the floor of x minus x min divided by delta">
                <i>N</i> = ⌊(<i>x</i> − <i>x</i><sub>min</sub>) / Δ⌋,
              </Equation>
              <Equation label="N equals x minus x min shifted right by d">
                <i>N</i> = (<i>x</i> − <i>x</i><sub>min</sub>) &gt;&gt; <i>d</i>.
              </Equation>
            </div>
          </Trick>

          <Trick number="3" title="Programming trick #3">
            <div className="grid items-center gap-4 md:grid-cols-[1fr_1fr]">
              <p>Distance within linear segment becomes</p>
              <Equation label="N bitwise and open parenthesis one shifted left by d close parenthesis minus one">
                <i>N</i> &amp; ((1 &lt;&lt; <i>d</i>) − 1).
              </Equation>
            </div>
          </Trick>

          <Trick number="4" title="Programming trick #4">
            <div className="grid items-center gap-4 md:grid-cols-[1fr_1fr]">
              <p>Arguments for the next level need avergaging</p>
              <Equation label="y equals one over n times the sum of f i of x i">
                <i>y</i> = 1/<i>n</i> ∑[<i>f</i><sub>i</sub>(<i>x</i><sub>i</sub>)],
              </Equation>
            </div>
            <p>
              but denominators <Equation inline label="n"><i>n</i></Equation> are known at compile time, so{' '}
              <Equation inline label="one over n">1/<i>n</i></Equation> is replaced by{' '}
              <Equation inline label="y times m shifted right by p">(<i>y</i> * <i>m</i>) &gt;&gt; <i>p</i></Equation>.
            </p>
          </Trick>

          <Trick number="5" title="Programming trick #5">
            <p>
              In training of float or double values models, functions are being modified and arguments are moved out of the definitions. It is corrected by slight drift of{' '}
              <Equation inline label="x min"><i>x</i><sub>min</sub></Equation> and{' '}
              <Equation inline label="x max"><i>x</i><sub>max</sub></Equation> (renormalization). But integer model rely on constant segment length of power of two. Mathematician from Greenwich university (Mike Poluektov) have proven mathematically that flexible modification of learning rate is mathematically equivalent to renormalization. So learning rates are chosen individually for each level and each record. The learning rates are adjusted and limits stay still.
            </p>
          </Trick>

          <Trick number="6" title="Programming trick #6">
            <p>Learning rates are shifts. 1/64 instead of 0.02 and 1/128 instead of 0.01.</p>
            <p className="pt-2 font-bold text-ink">That is all programmers need to know to understand the code</p>
          </Trick>
        </div>
      </div>
    </section>
  )
}
