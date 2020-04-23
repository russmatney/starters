(ns fullstack.ui.core
  (:require
   [reagent.core :as reagent]
   [fullstack.ui.views :as views]
   [fullstack.ui.events :as events]
   [fullstack.ui.routes :as routes]
   [re-frame.core :as rf]))

(defn dev-setup []
  (enable-console-print!))

(defn mount-root []
  (rf/clear-subscription-cache!)
  (routes/init-routes!)
  (reagent/render [views/root]
                  (.getElementById js/document "app")))

(defn ^:export init
  "Called on page-load in public/index.html.
  Only called once - does not get called on 'live-reloads' during development.
  "
  []
  (dev-setup)
  (mount-root)

  (rf/dispatch-sync [::events/init]))
