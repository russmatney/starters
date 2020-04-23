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
- Devcards

Backend:

- Systemic
- PneumaticTubes
- dev alias undos java-error-tossing optimizations

### TODO Features

- Reitit router
- .dir-locals
- tick time support across tubes
- tubes fork that supports custom handlers
- embedded nrepl on backend
- user ns starts server
- env-based server host and port
- atom-watcher pattern for pushing results to fe

### Install Deps

```sh
cd fullstack
yarn install
shadow-cljs compile app
```

#### Start running from emacs

Usually via `M-x cider-jack-in-clj&cljs`, select `shadow-cljs` (twice), then `:app`.

## TODO Clojure CLI tool

- Cli-matic
- GraalVM usage
