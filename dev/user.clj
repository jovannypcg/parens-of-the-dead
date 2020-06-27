(ns user
  (:require [reloaded.repl :as repl :refer [system reset stop]]
            [undead.system]))

(repl/set-init! #'undead.system/create-system)
