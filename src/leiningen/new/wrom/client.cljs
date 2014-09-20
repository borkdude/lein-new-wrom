(ns {{name}}.client
    (:require-macros [cljs.core.async.macros :refer (go)])
    (:require [om.core :as om :include-macros true]
              [om.dom :as dom :include-macros true]
              [cljs.core.async :refer [<!]]
              [cljs-http.client :as http]))

(enable-console-print!)

(def app-state (atom {:text ""}))

(om/root
 (fn [app owner]
   (reify
     om/IWillMount
     (will-mount [_]
       (go (let [response (<! (http/get
                               (str "/welcome-message")))]
             (if (= (:status response)
                    200)
               (om/update! app :text (:body response))
               (om/update! app :text "Server error")))))
     om/IRender
     (render [_]
       (dom/h1 nil (:text app)))))
 app-state
 {:target (. js/document (getElementById "app"))})
