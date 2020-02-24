# Starters

A handful of starter templates for miscellaneous projects

[Related blob post](http://russmatney.com/2020-02-21-clojure-repo-starters/).

## TODO ClojureScript Frontend

- Shadow-cljs
- Re-frame
- Reagent
- Garden/Herb

## Clojure + ClojureScript Fullstack App

Currently only supported via REPL (no production build process in place)

Frontend:

- Shadow-cljs
- Re-frame
- Reagent

Backend:

- Systemic
- PneumaticTubes

#### Install Deps

```sh
yarn install
shadow-cljs compile app
```

#### Start running from emacs

Usually via `M-x cider-jack-in-clj&cljs`, select `shadow-cljs` (twice), then `:app`.

## TODO Clojure CLI tool

- Cli-matic
- GraalVM usage
