(ns fullstack.ui.devcards
  (:require
   [devcards.core :as dc]
   [reagent.core :as r])
  (:require-macros
   [devcards.core :refer [defcard defcard-rg]]))

(defn ^:export main []
  (dc/start-devcard-ui!*))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Examples
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(defcard one-defcard
  "# *Hooray* for markdown"
  (r/as-element
    [:div
     [:h1 "Example h1"]]))

(defcard-rg two-defcard
  "# *Hooray* for reagent/hiccup support"
  [:div
   [:h1 "Example h1"]])
