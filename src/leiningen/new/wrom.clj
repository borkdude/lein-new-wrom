(ns leiningen.new.wrom
  (:require [leiningen.new.templates :refer [renderer name-to-path ->files]]))

(def render (renderer "wrom"))

(defn wrom [name]
  (let [data {:name name
              :sanitized (name-to-path name)}]
    (->files data
      ["project.clj" (render "project.clj" data)]
      ["src/{{sanitized}}/client.cljs" (render "client.cljs" data)]
      ["src/{{sanitized}}/server.clj" (render "server.clj" data)]
      ["resources/public/index.html" (render "index.html" data)]
      ["resources/public/style.css" (render "style.css" data)]
      [".gitignore" (render "gitignore" data)])))
