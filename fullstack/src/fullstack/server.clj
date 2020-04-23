(ns fullstack.server
  (:require
   [org.httpkit.server :as server]
   [pneumatic-tubes.core :as tubes]
   [pneumatic-tubes.httpkit :refer [websocket-handler]]
   [systemic.core :as sys :refer [defsys]]))

(defsys *transmitter*
  "Pneumatic tube for transmitting data"
  (tubes/transmitter))

(defsys *tx*
  "Function to transmit data to the provided tube"
  (fn [tube event]
    (tubes/dispatch *transmitter* tube event)))

(defn list-files []
  [{:file/name         "nother-example.org"
    :file/last-touched "yesterday"}
   {:file/name         "example.org"
    :file/last-touched "yesterday"}])

(defsys *rx*
  "Receiver for handling web events"
  (tubes/receiver
    {:init
     (fn [tube _]
       (*tx* tube [:init.success {}])
       tube)

     :list-files
     (fn [tube _]
       (println "list-files hit on server")
       (*tx* tube [:list-files.success (list-files)])
       tube)}))

(defsys *server*
  :start
  (server/run-server (websocket-handler *rx*) {:port 8999})
  :stop
  (*server*))

(comment
  (sys/start!)
  (sys/state `*server*)
  (sys/start! `*server*)
  (sys/restart!)
  (sys/stop!))
