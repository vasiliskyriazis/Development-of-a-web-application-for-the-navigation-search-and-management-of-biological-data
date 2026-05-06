# 🧬 VVDb: Πλατφόρμα Πλοήγησης & Διαχείρισης Βιολογικών Δεδομένων

Μια ολοκληρωμένη Full-Stack εφαρμογή για τη διαχείριση γονιδιωματικών δεδομένων, αναπτυγμένη στο πλαίσιο του μαθήματος **Ειδικά Θέματα Βιοπληροφορικής ΙΙ**.

---

## 🏗️ Αρχιτεκτονική & Τεχνική Ανάλυση

Η εφαρμογή ακολουθεί την αρχιτεκτονική διαχωρισμού **Client-Server**, επιτρέποντας την ανεξάρτητη ανάπτυξη και κλιμάκωση του Backend και του Frontend.

### 🖥️ Backend: Spring Boot (Java)
Το Backend λειτουργεί ως ένας εύρρωστος **REST API Server** που διαχειρίζεται τη λογική και την ασφάλεια των δεδομένων.
* **Data Access Layer:** Χρήση του **Spring Data JPA** για την επικοινωνία με τη MySQL. Οι οντότητες (`Gene`, `Transcript`, `Variant`) αντικατοπτρίζουν τις βιολογικές σχέσεις.
* **Service Layer:** Υλοποίηση του **JPA Criteria API** για την υποστήριξη σύνθετης αναζήτησης με Boolean λογική (AND, OR, NOT).
* **Security:** Ενσωμάτωση **Spring Security** με Basic Authentication. Διαχωρισμός ρόλων:
    * `USER`: Πρόσβαση μόνο για ανάγνωση και αναζήτηση.
    * `ADMIN`: Πλήρη δικαιώματα CRUD (Create, Read, Update, Delete).

### 🎨 Frontend: Angular (SPA)
Η διεπαφή χρήστη είναι μια **Single Page Application** σχεδιασμένη για μέγιστη ταχύτητα και φιλικότητα προς τον ερευνητή.
* **Component-Based Design:** * `Gene-List`: Προβολή και φιλτράρισμα των δεδομένων σε πραγματικό χρόνο.
    * `Gene-Details`: Εμφάνιση συσχετισμένων Transcripts & Variants για κάθε γονίδιο.
    * `Gene-Edit/Create`: Χρήση **Reactive Forms** με validators για την επικύρωση των δεδομένων πριν την αποστολή.
* **State Management & Services:** * `GeneService`: Διαχειρίζεται όλα τα HTTP calls προς το API.
    * `AuthService`: Διαχειρίζεται τα διαπιστευτήρια και προσθέτει το Authorization Header σε κάθε αίτημα.
* **UI/UX:** Responsive σχεδιασμός με **Dark/Light Mode Toggle** και Bootstrap 5.

---

## 📊 Σχεδιασμός Βάσης Δεδομένων (VVDb)

Η βάση δεδομένων VVDb ενσωματώνει δεδομένα από **Ensembl BioMart** και **ClinVar**, ακολουθώντας ένα αυστηρό σχεσιακό μοντέλο:
* **Gene:** Η κεντρική οντότητα με πεδία όπως Symbol, Description, GC Content κ.α.
* **Transcript (1:N):** Κάθε γονίδιο συνδέεται με πολλαπλές μεταγραφές.
* **Variant (M:N):** Πολυμορφισμοί που συνδέονται με γονίδια μέσω πίνακα συσχέτισης (Join Table).



---

## 🛠️ Οδηγίες Εγκατάστασης & Χρήσης

### 1. Βάση Δεδομένων (MySQL)
Δημιουργήστε το schema `vvdb` και εκτελέστε τα αρχεία SQL:
1. `create_tables.sql`: Δημιουργία δομής.
2. `insert_data.sql`: Εισαγωγή βιολογικών δεδομένων.

### 2. Ρύθμιση Backend
```bash
cd gene_backend
# Βεβαιωθείτε ότι οι ρυθμίσεις στο application.properties είναι σωστές
./mvnw spring-boot:run
API Endpoint: http://localhost:8080/api/genes

### 3. Ρύθμιση Frontend
```bash
cd gene_frontend
npm install
ng serve
Πρόσβαση μέσω browser στο: http://localhost:4200



