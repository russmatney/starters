(ns fullstack.ui.views.home
  (:require [re-frame.core :as rf]))

(defn page
  []
  [:div
   [:input
    {:on-click #(rf/dispatch [:navigate :routes/files])
     :type     "button"
     :value    "Navigate to Files Page"}]

   [:h2 "Home"]])
