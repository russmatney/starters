(ns fullstack.ui.views.files
  (:require
   [re-frame.core :as rf]
   [fullstack.ui.subs :as subs]))

(defn file-comp [file]
  [:div
   [:h1 (:file/name file)]
   [:p (str "Last touched: " (:file/last-touched file))]])

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
        {:on-click #(rf/dispatch [:navigate :routes/file {:id (:file/id file)}])}
        [file-comp file]])]))

(defn files-page
  []
  [:div
   [:h2
    "Files"]
   [files-list]])

(defn file-page
  []
  (let [active-file @(rf/subscribe [::subs/active-file])]
    [file-comp active-file]))
