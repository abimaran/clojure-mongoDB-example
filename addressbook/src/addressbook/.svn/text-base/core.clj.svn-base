(ns addressbook.core
  (:use [compojure.core]
        [ring.adapter.jetty]
        [hiccup.core]
	[addressbook.repository])
  (:require [compojure.route :as route]
            [compojure.handler :as handler]))


(def recs '({:name "test" :emailId "abc@abc.com" :age "6"} {:name "foo" :emailId "xyz@xyz.com"  :age "70"}))

(defn to-html-table [m]
    (str "<tr>" " <td>" (str (:name m) "</td>" "<td>" (:emailId m) "</td>" "<td>" (:age m)) "</td>" "</tr>"))

(defroutes example
  (GET "/" []
       (html
        [:html
         [:head
          [:title "Employee details"]
	  [:h1 [:center "Employee Details Database"]]]
	  [:body
	  [:p {:align "center"} 
	  [:form {:method "POST" :action "/update"}
	  "User Name : " [:input {:name "name" :type "text"}] [:br]
	  "Email Id : "  [:input {:name "emailId" :type "text"}] [:br]
	  "Age : " [:input {:name "age" :type "text"}] [:br]
	  [:input {:type "submit" :value "Save"}]]]]]))
  (POST "/update"  {params :params}
         (insert-rec params)
	  (html
	  [:html
	  [:head
	  [:title "Employee Details"]
	  [:h1 [:center "Employee Details Database"]]]
	  [:body
	  [:p {:align "centre"}
           "Your name : " (:name params) ", Your data have been updated"]]]))
  
  (GET "/view" []
       (html
        [:html
        [:head
         [:title "Employee Details"]]
        [:body
         [:h1 "Employee Details"]
         [:p
          [:table {:border "1"}
           [:thread
            [:tr
             [:th "Name "]
             [:th "Email ID "]
             [:th "Age "]
            ]
           ]
           [:tbody (apply str (interpose " \n " (map to-html-table (filter-db (fetch-rec)))))]]]]]))

  (GET "/edit" []
       (html
        [:html
         [:head
          [:title "Employee details"]]
         [:body
          [:h1 "Modify Employee Details"]
          [:p
           [:form {:name "modify" :method "GET"}
            "Enter Name For Modify : " [:input {:name "name" :type "text"}]
            [:input {:type "submit" :value "Edit" :onclick "modify.action='/editvalue'"}]
            [:input {:type "submit" :value "Delete" :onclick "modify.action='/delete'"}]]]]]))

  (GET "/editvalue" {params :params}
       (html
        [:html
         [:head
          [:title "Edit Employee Details"]]
         [:body
          [:p
           [:form {:method "POST" :action "/modified"}
            "Name of the Employee : " (:name params)[:br]
            "Email ID : "[:input {:name "emailsId" :type "text"}][:br]
            "Age : " [:input {:name "age" :type "text"}][:br]
            [:input {:type "submit" :value "Save"}]
            ]]]]))

  (POST "/modified" {params :params}
               (update-rec params)) ;update the address book.

  (GET "/delete" {params :params}
       (delete-rec params)
       (html
        [:html
         [:head
          [:title "Deleted"]]
         [:body
          "Employee " (:name params) "'s datails are deleted"]])) ; delete from database

  )



  
  (route/not-found "Page not found")

(def app
  (handler/site example))



