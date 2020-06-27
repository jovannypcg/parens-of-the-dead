(ns user
  (:require [reloaded.repl :as repl :refer [reset stop system]]
            [undead.system]))

(repl/set-init! #'undead.system/create-system)
