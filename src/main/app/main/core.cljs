(ns app.main.core
  (:require [app.config :as config]))

(def Electron (js/require "electron"))
(def BrowserWindow (.-BrowserWindow Electron))
(def app (.-app Electron))

(defn create-window [index]
  (let [win (BrowserWindow. (clj->js {:webPreferences {:nodeIntegration true}
                                      :show false
                                      :width 400 
                                      :height 200}))]
    (doto win
      (.loadFile index)
      (.once "ready-to-show" #(.show win)))))

(defn start []
  (create-window config/index-html)
  (when config/test-html
    (create-window config/test-html)))

(.on app "ready" start)