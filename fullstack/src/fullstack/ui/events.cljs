(ns fullstack.ui.events
  (:require
   [re-frame.core :as rf]
   [pneumatic-tubes.core :as tubes]
   [fullstack.ui.db :as db]))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Tubes setup
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(defn on-disconnect []
  (.log js/console "Connection with server lost."))

(defn on-connect-failed []
  (.log js/console "Connection with server failed."))

(defn on-connect []
  (.log js/console "Connection with server started."))

(defn on-receive [event-v]
  (.log js/console (str "Event received from server: " event-v))
  (rf/dispatch event-v))

(def tube
  (tubes/tube
    (str "ws://localhost:8999/ws")
    on-receive
    on-connect
    on-disconnect
    on-connect-failed))

(def send-to-server
  (rf/after (fn [_ v] (tubes/dispatch tube v))))

(rf/reg-fx
  :tubes-create
  (fn [_event-v]
    (tubes/create! tube)))

(rf/reg-fx
  :tubes-dispatch
  (fn [event-v] (tubes/dispatch tube event-v)))


;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Init App
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(rf/reg-event-fx
  ::init
  (fn [_]
    {:db           db/initial-db
     :tubes-create true}))

(rf/reg-event-fx
  ::fetch-files
  [send-to-server]
  (fn [_cofx _event]
    {:tubes-dispatch [:fetch-files]}))

(rf/reg-event-fx
  :fetch-files.success
  [rf/trim-v]
  (fn [{:keys [db]} [files]]
    {:db (assoc db :files files)}))

(rf/reg-event-db
  ::set-active-file-id
  [rf/trim-v]
  (fn [db [file-id]]
    (assoc db :active-file-id file-id)))
