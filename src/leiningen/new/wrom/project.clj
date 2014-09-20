(defproject {{name}} "0.1.0-SNAPSHOT"
  :description "FIXME: write this!"
  :url "http://example.com/FIXME"

  :dependencies [[org.clojure/clojure "1.6.0"]
                 [org.clojure/clojurescript "0.0-2322"]
                 [org.clojure/core.async "0.1.267.0-0d7780-alpha"]
                 [org.webjars/react "0.11.1"]
                 [om "0.7.1"]
                 [cljs-http "0.1.14"]
                 [ring/ring-core "1.3.1"]
                 [ring/ring-jetty-adapter "1.3.1"]]

  :plugins [[lein-cljsbuild "1.0.4-SNAPSHOT"]
            [lein-ring "0.8.10"]]

  :source-paths ["src"]

  :cljsbuild {:builds [{:id "{{name}}"
                        :source-paths ["src"]
                        :compiler
                        {:output-to "resources/public/{{sanitized}}.js"
                         :output-dir "resources/public/out"
                         :optimizations :none
                         :source-map true}}]}

  :ring {:handler {{name}}.server/app
         :nrepl {:start? true :port 4500}
         :port 8090}

  :global-vars {*print-length* 20})
