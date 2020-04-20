(ns app.render.core
  (:require [reagent.core :as r]
            [reagent.dom :as rdom]))

(defonce timer (r/atom (js/Date.)))

(defonce time-color (r/atom "#f34"))

(defonce time-updater (js/setInterval
                        #(reset! timer (js/Date.)) 1000))

(defn clock
  []
  (let [time-str (-> @timer .toTimeString (clojure.string/split " ") first)]
    [:div {:class "flex mx-auto items-center" :style {:color @time-color}}
     [:h1 {:class "text-6xl text-bold text-center"} time-str]]))

(defn simple-example []
  [:div {:class "flex mx-auto items-center"}
   [:h1 {:class "text-3xl text-bold text-center"} "Hello from Reagent..."]])

(defn start []
  (rdom/render [clock]
            (js/document.getElementById "app")))

(start)