import CircuitTrace from './CircuitTrace.jsx'
import CodeBlock from './CodeBlock.jsx'
import { computeReduceCode, inferenceCode, layerDataCode } from '../data/code.js'

const stages = [
  ['1', 'INNER Compute', 'Populate the intermediate matrix.'],
  ['2', 'INNER ReduceVector', 'Average each row into the intermediate vector.'],
  ['3', 'OUTER Compute', 'Populate the outer vector.'],
  ['4', 'OUTER ReduceVector', 'Average the outer vector into predicted.'],
]

export default function Implementation() {
  return (
    <section id="implementation" className="relative scroll-mt-24 overflow-hidden border-t border-line bg-surface py-16 sm:py-24">
      <CircuitTrace className="-right-32 -top-16 h-80 w-[42rem] opacity-70" />
      <div className="relative z-10 mx-auto max-w-[1240px] px-5 sm:px-8 lg:px-12">
        <div className="max-w-4xl">
          <h2 className="text-balance text-[clamp(2.5rem,5vw,4.5rem)] font-bold leading-[1.02] tracking-[-0.045em] text-ink">
            Was it like landing on the moon step?
          </h2>
          <p className="mt-7 text-lg leading-8 text-body">
            The previous toy example has one FPGA unfriendly code. It is <strong className="text-ink">structure</strong>. The operations like
          </p>
          <div className="mt-5 max-w-xl">
            <CodeBlock title="FPGA-unfriendly operation" code="F.f[F.index] += F.f[F.index + 1];" compact />
          </div>
          <p className="mt-5 text-lg leading-8 text-body">makes generated bitstream too complex.</p>
        </div>

        <div className="mt-14 grid gap-12 border-t border-line pt-12 lg:grid-cols-[0.88fr_1.12fr] lg:gap-14">
          <div className="space-y-7">
            <div className="article-copy">
              <p>The second link at the top shows two layer KAN as two tables of integers. It is prediction of determinants of 3 × 3 matrices with 1% accuracy.</p>
              <p>I show here data structure and inference step. The convenient names for two layer KAN are INNER layer and OUTER layer. Number of features 9, number of blocks in the inner layer 16, here is the layer data:</p>
            </div>
            <CodeBlock title="Layer data" code={layerDataCode} compact />
            <div className="article-copy">
              <p>In order to complete model to the level allowing to use it, we need only domains for all functions, and they are the same for entire layer. The features are bytes and target and intermediate values have ranges [-20'480, 20'480]. The linear segments are even and have lengths as power of two 128 and 2048.</p>
              <p>Only two short functions are needed for inferences: Compute and Reduce.</p>
            </div>
          </div>

          <div className="lg:border-l lg:border-line lg:pl-14">
            <h3 className="text-2xl font-bold tracking-[-0.025em] text-ink">Four one-FPGA-cycle inference stages</h3>
            <ol className="mt-7 space-y-1" aria-label="Inference stages">
              {stages.map(([number, title, text]) => (
                <li key={number} className="stage-row">
                  <span className="stage-number" aria-hidden="true">{number}</span>
                  <div>
                    <p className="font-bold text-ink">{title}</p>
                    <p className="mt-1 text-sm leading-6 text-muted">{text}</p>
                  </div>
                </li>
              ))}
            </ol>
          </div>
        </div>

        <div className="mt-12 grid gap-8 lg:grid-cols-2">
          <div>
            <CodeBlock title="Compute and ReduceVector" code={computeReduceCode} />
            <p className="mt-5 text-base leading-7 text-body">
              Indexes are positions of the left point in a segment for particular input, offsets are distances for this left point to argument within a segment. Compute returns them for training only, they are not used for inferences.
            </p>
          </div>
          <CodeBlock title="Inference" code={inferenceCode} />
        </div>

        <p className="mt-12 max-w-5xl border-l-2 border-coral pl-5 text-lg font-medium leading-8 text-ink sm:pl-7">
          The output of INNER layer is intermediate vector. Compute outputs result to the matrix and intermediate vector only computes averages in rows. OUTER layer outputs results into vector and scalar predicted is an average.
        </p>
      </div>
    </section>
  )
}
