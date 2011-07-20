(defproject addressbook "0.1.0"
  :description "Address Book"
  :dependencies [[org.clojure/clojure "1.2.0"]
                 [org.clojure/clojure-contrib "1.2.0"]
		  [compojure "0.6.4"]
		  [hiccup "0.2.6"]
		 [karras "0.6.0"]]
  :dev-dependencies [[swank-clojure "1.2.1"]
                     [lein-ring "0.4.5"]
                     [ring/ring-devel "0.2.0"]]
  :ring {:handler addressbook.core/app})