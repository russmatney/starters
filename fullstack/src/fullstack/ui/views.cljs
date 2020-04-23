(ns fullstack.ui.views
  (:require
   [fullstack.ui.subs :as subs]
   [re-frame.core :as rf]))

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

(defn home-page []
  [:div
   [files-list]])

(defn show-page
  []
  (let [page @(rf/subscribe [::subs/current-page])
        page (or page :home)]
    (case page
      :home [home-page])))

(defn root []
  (rf/clear-subscription-cache!)
  [:div#root
   {:style {:width "100vw"}}
   [show-page]])
