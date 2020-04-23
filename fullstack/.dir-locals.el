;;; Directory Local Variables
;;; For more information see (info "(emacs) Directory Variables")

((clojure-mode
  (cider-known-endpoints . (("localhost" "7888")))
  (cider-preferred-build-tool . shadow-cljs)
  (cider-jack-in-default . shadow-cljs)
  (cider-default-cljs-repl . shadow)
  (cider-shadow-default-options . ":app")
  (cider-shadow-cljs-global-options . "-A:dev"))
 (clojurescript-mode
  (cider-known-endpoints . (("localhost" "4001")))
  (cider-preferred-build-tool . shadow-cljs)
  (cider-jack-in-default . shadow-cljs)
  (cider-default-cljs-repl . shadow)
  (cider-shadow-default-options . ":app")
  (cider-shadow-cljs-global-options . "-A:dev")))
