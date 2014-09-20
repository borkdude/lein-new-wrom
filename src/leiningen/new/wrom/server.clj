(ns {{name}}.server
    (:require
     [ring.middleware.resource :refer (wrap-resource)]
     [ring.util.response :refer (redirect)]))

(defn handler [request]
  (case (:uri request)
    "/"
    (redirect "/index.html")
    "/welcome-message"
    {:status  200
     :headers {"Content-Type" "text/html"}
     :body    "Hello world from server!"}
    {:status  404
     :headers {"Content-Type" "text/html"}
     :body    (str "Cannot find:" (:uri request))}))

(def app
  (-> handler
      ;; static resources in resources/public
      (wrap-resource "public")
      ;; static resources from webjars dependencies
      (wrap-resource "/META-INF/resources")))
