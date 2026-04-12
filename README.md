# ⭐ StarsGallery — LAB 7

Application Android affichant une galerie de stars
avec images circulaires, notes et filtrage dynamique.

## 🎬 Demo



https://github.com/user-attachments/assets/3abc341d-ca62-426e-8d43-d37494ac03a1



## 📱 Fonctionnalités

- Splash Screen animé (rotation, scale, translation)
- Liste de stars avec RecyclerView
- Images circulaires chargées via Glide
- Barre de recherche SearchView (filtre en temps réel)
- Popup pour modifier la note d'une star
- Menu de partage de l'application

## 🏗️ Architecture
stor.ensa.ma.stor/
├── beans/
│   └── Star.java              ← Modèle de données
├── dao/
│   └── IDao.java              ← Interface CRUD générique
├── service/
│   └── StarService.java       ← Singleton + données
├── adapter/
│   └── StarAdapter.java       ← RecyclerView + Filter
└── ui/
├── SplashActivity.java    ← Écran animé démarrage
└── ListActivity.java      ← Liste + Search + Share

## 🛠️ Stack Technique

- **Language** : Java
- **Architecture** : DAO Pattern + Singleton
- **UI** : RecyclerView + ViewHolder Pattern
- **Images** : Glide (chargement distant)
- **Composants** : CircleImageView, RatingBar, SearchView
- **Min SDK** : API 24

## 📦 Dépendances

```gradle
implementation 'androidx.recyclerview:recyclerview:1.3.1'
implementation 'de.hdodenhof:circleimageview:3.1.0'
implementation 'com.github.bumptech.glide:glide:4.15.1'
```

## 🚀 Installation

1. Cloner le repository
2. Checkout sur la branche lab7
3. Ouvrir dans Android Studio
4. Sync Gradle
5. Lancer sur émulateur ou appareil réel

## 🎨 Fonctionnement
SplashActivity (5 secondes animées)
↓
ListActivity
├── RecyclerView → StarAdapter
│       ├── Glide charge les images
│       └── Clic → AlertDialog modifier note
├── SearchView → filtre en temps réel
└── Menu → partage via ShareCompat
