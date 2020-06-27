(ns undead.system
  (:require [org.httpkit.server :refer [run-server]]
            [com.stuartsierra.component :as component]))

(defn app
  [req]
  {:status  200
   :headers {"Content-Type" "text/html"}
   :body    "Hello HTTP"})

(defn- start-server
  [handler port]
  (let [server (run-server handler {:port port})]
    (println (str "Server up and running on localhost:" port))
    server))

(defn- stop-server
  [server]
  (when server
    (server))) ;; run-server returns a fn that stops itself

(defrecord ParensOfTheDead []
  component/Lifecycle
  (start [this]
    (assoc this :server (start-server app 3000)))

  (stop [this]
    (stop-server (:server this))
    (dissoc this :server)))

(defn create-system
  []
  (ParensOfTheDead.))

(defn -main
  [& args]
  (.start (create-system)))
