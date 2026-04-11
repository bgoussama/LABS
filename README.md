# 🍕 PizzaRecipes — LAB 6

Application Android affichant une collection 
de recettes de pizzas développée en Java.

## 🎬 Demo

https://github.com/user-attachments/assets/d69cf0d7-2979-45da-a71a-c7071638a12b


## 📱 Fonctionnalités

- Splash Screen orange (2 secondes)
- Liste de 10 pizzas avec images
- Détail complet : ingrédients + étapes
- Navigation entre écrans via Intent

## 🏗️ Architecture du projet






com.exemple.pizzarecipes/
├── classes/
│   └── Produit.java          ← Modèle de données
├── dao/
│   └── IDao.java             ← Interface CRUD
├── service/
│   └── ProduitService.java   ← Singleton + données
├── adapter/
│   └── PizzaAdapter.java     ← ListView adapter
└── ui/
├── SplashActivity.java   ← Écran démarrage
├── ListPizzaActivity.java← Liste pizzas
└── PizzaDetailActivity.java← Détail pizza

## 🛠️ Stack Technique

- **Language** : Java
- **Architecture** : DAO Pattern + Singleton
- **UI** : ListView + BaseAdapter
- **Min SDK** : API 24

## 🚀 Installation

1. Cloner le repository
2. Ouvrir dans Android Studio
3. Sync Gradle
4. Lancer sur émulateur ou appareil réel
