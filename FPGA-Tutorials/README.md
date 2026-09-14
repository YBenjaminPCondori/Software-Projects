# OpenKAN FPGA Debut — local UI/UX rebuild

A responsive React rebuild of the static [OpenKAN FPGA Debut page](http://openkan.org/FPGA_debut.html), created for private learning and local viewing only.

The article text, equations, source links, navigation destinations, and C++ examples are preserved from the original page. The presentation and interaction design are new.

## Run locally

Prerequisites:

- Node.js 20.19+ or 22.12+
- npm

From the project folder:

```bash
npm install
npm run dev
```

Open the local URL printed by Vite, normally `http://localhost:5173`.

Production-style local preview:

```bash
npm run build
npm run preview
```

Quality checks:

```bash
npm run lint
npm run build
```

## Project structure

```text
FPGA-Tutorials/
├─ .design/
│  ├─ concept-hero.png
│  ├─ concept-programming-tricks.png
│  └─ concept-implementation.png
├─ src/
│  ├─ components/
│  │  ├─ CircuitTrace.jsx
│  │  ├─ CodeBlock.jsx
│  │  ├─ Equation.jsx
│  │  ├─ Footer.jsx
│  │  ├─ Hero.jsx
│  │  ├─ Icons.jsx
│  │  ├─ Implementation.jsx
│  │  ├─ Logo.jsx
│  │  ├─ Navbar.jsx
│  │  ├─ ProgrammingTricks.jsx
│  │  └─ ResourceMenu.jsx
│  ├─ data/
│  │  ├─ code.js
│  │  └─ navigation.js
│  ├─ App.jsx
│  ├─ main.jsx
│  └─ styles.css
├─ .gitignore
├─ eslint.config.js
├─ index.html
├─ package.json
├─ package-lock.json
├─ vite.config.js
└─ README.md
```

## UI/UX improvements

- Replaced the fixed table/sidebar layout with a responsive editorial page that works from small phones to wide desktops.
- Added a sticky, keyboard-accessible navbar with clear in-page destinations and an expandable map of the original OpenKAN navigation.
- Reframed the four source links as a scannable, high-contrast resource panel.
- Turned the six programming notes into a numbered learning sequence with stronger headings, spacing, and readable equation treatments.
- Grouped the long C++ examples into labelled, horizontally scrollable code panels with copy controls.
- Added a visual four-stage inference sequence without changing the source code or technical meaning.
- Added semantic landmarks, a skip link, visible focus states, descriptive link names, reduced-motion support, and accessible menu state.
- Uses local variable-font packages, so the page does not depend on Google Fonts or another font CDN.

## Content and asset limitations

- The inspected source page is static; no dynamic content, forms, accounts, or protected application state were found.
- The source page contains no images, so there were no original raster assets to reuse. The circuit/chip decoration in this rebuild is code-native SVG/CSS.
- The original MathJax output was replaced with accessible HTML/CSS equation formatting to keep the local setup small. The equations are unchanged, but the typesetting is not a full LaTeX renderer.
- Site-wide navigation still points to the original `openkan.org` pages because only the requested FPGA Debut homepage is rebuilt locally.
- External repository links require an internet connection. The rebuilt article itself works locally after dependencies are installed.
- This project is intentionally configured for local use and is not prepared or licensed here for public deployment.
