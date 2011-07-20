(ns addressbook.repository
  (:use karras.core
    karras.collection
    karras.sugar))

(def test-db (collection (connect) :mydb :user))

(defn no-of-docs []
  (count-docs test-db))


(defn insert-rec [rec]
  (println "Data inserted")
  (insert test-db rec))

(defn fetch-rec []
  (fetch-all test-db))

(defn filter-db [data]
  (map #(dissoc % :_id) data))

(defn update-rec [rec]
  
  (update test-db (modify (where (eq :name (:name rec))) :emailId (:emailId rec) :age (:age rec))))

(defn delete-rec [{p-name :name}]
  ;(def datav (fetch-one test-db (where (eq :name p-name))))
 ; (println (:_id datav))
   (delete test-db (where (eq :name p-name)))
  )