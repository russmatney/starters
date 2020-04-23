(ns fullstack.ui.views.files
  (:require
   [re-frame.core :as rf]
   [fullstack.ui.subs :as subs]))

(defn files-list
  []
  (let [files @(rf/subscribe [::subs/files])]
    [:div
     {:style {:display        "flex"
              :flex-direction "column"}}
     [:div "Files"]
     (for [file files]
       ^{:key (:file/name file)}
       [:div
        [:h1 (:file/name file)]
        [:p (str "Last touched: " (:file/last-touched file))]])]))

(defn page
  []
  [:div
   [:h2
    "Files"]])
