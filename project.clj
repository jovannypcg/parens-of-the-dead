(defproject parens-of-the-dead "1.0.0"
  :description    "A series of zombie-themed games written in Clojure and ClojureScript."
  :url            "www.parens-of-the-dead.com"
  :jvm-opts       ["-XX:MaxPermSize=256m"]
  :source-paths   ["src/main/clj"]
  :test-paths     ["test/main/clj"]
  :resource-paths ["resources" "resources/public"]
  :main           undead.system

  :plugins        [[lein-cljfmt "0.6.6"]
                   [lein-nsorg "0.3.0"]]

  :dependencies   [[org.clojure/clojure "1.10.1"]
                   [http-kit "2.3.0"]]

  :profiles       {:dev {:plugins []
                         :dependencies []
                         :source-paths ["dev"]}}

  :aliases        {"lint-fix" ["do"
                               ["nsorg" "--replace"]
                               ["cljfmt" "fix"]]})
