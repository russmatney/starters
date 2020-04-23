(ns fullstack.ui.subs
  (:require [re-frame.core :as rf]))

(rf/reg-sub
  ::files
  (fn [db]
    (:files db)))

(rf/reg-sub
  ::active-file-id
  (fn [db] (:active-file-id db)))

(rf/reg-sub
  ::active-file
  :<- [::active-file-id]
  :<- [::files]
  (fn [[id files]]
    (first (filter #(= id (:file/id %)) files))))
