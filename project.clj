(defproject parens-of-the-dead "1.0.0"
  :description    "A series of zombie-themed games written in Clojure and ClojureScript."
  :url            "www.parens-of-the-dead.com"
  :jvm-opts       ["-XX:MaxMetaspaceSize=256m"]
  :source-paths   ["src/main/clj"]
  :test-paths     ["test/main/clj"]
  :resource-paths ["resources" "resources/public"]
  :main           undead.system

  :plugins        [[lein-cljfmt "0.6.6"]
                   [lein-nsorg "0.3.0"]]

  :dependencies   [[com.stuartsierra/component "1.0.0"]
                   [compojure "1.6.1"]
                   [http-kit "2.3.0"]
                   [org.clojure/clojure "1.10.1"]
                   [org.clojure/clojurescript "1.10.764"]]

  :aliases        {"lint-fix" ["do"
                               ["nsorg" "--replace"]
                               ["cljfmt" "fix"]]}

  :profiles       {:dev {:plugins      [[lein-cljsbuild "1.1.8"]
                                        [lein-figwheel "0.5.20"]]
                         :dependencies [[reloaded.repl "0.2.4"]]
                         :source-paths ["dev"]

                         ;; NPE exception is thrown when missing keys
                         ;; https://clojurians-log.clojureverse.org/figwheel/2018-04-23
                         :cljsbuild {:builds [{:id "main"
                                               :source-paths ["src/" "dev/"]
                                               :figwheel true
                                               :compiler {:output-to            "target/classes/public/app.js"
                                                          :output-dir           "target/classes/public/out"
                                                          :optimizations        :none
                                                          :recompile-dependents true
                                                          :source-map           true}}]}}})
