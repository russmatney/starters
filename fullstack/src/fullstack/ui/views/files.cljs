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
        [:input
         {:on-click #(rf/dispatch [:navigate :routes/file {:id (:file/id file)}])
          :type     "button"
          :value    (str "Navigate to File Page: " (:file/name file))}]

        [file-comp file]])]))

(defn files-page
  []
  [:div
   [:input
    {:on-click #(rf/dispatch [:navigate :routes/home])
     :type     "button"
     :value    "Navigate to Home Page"}]

   [:h2 "Files"]

   [files-list]])

(defn file-page
  []
  (let [active-file @(rf/subscribe [::subs/active-file])]
    [:div
     [:input
      {:on-click #(rf/dispatch [:navigate :routes/home])
       :type     "button"
       :value    "Navigate to Home Page"}]
     [:input
      {:on-click #(rf/dispatch [:navigate :routes/files])
       :type     "button"
       :value    "Navigate to Files Page"}]

     [file-comp active-file]]))
