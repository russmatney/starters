(ns fullstack.ui.subs
  (:require [re-frame.core :as rf]))

(rf/reg-sub
  ::current-page
  (fn [db]
    (:current-page db)))

(rf/reg-sub
  ::files
  (fn [db]
    (:files db)))
