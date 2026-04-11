package com.exemple.pizzarecipes.service;

import com.exemple.pizzarecipes.R;
import com.exemple.pizzarecipes.classes.Produit;
import com.exemple.pizzarecipes.dao.IDao;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProduitService implements IDao<Produit> {

    private static ProduitService INSTANCE;
    private final List<Produit> data = new ArrayList<>();

    private ProduitService() { seed(); }

    public static ProduitService getInstance() {
        if (INSTANCE == null) INSTANCE = new ProduitService();
        return INSTANCE;
    }

    private void seed() {
        data.add(new Produit("BARBECUED CHICKEN PIZZA", 3.0,
                R.mipmap.pizza1, "35 min",
                "- 2 boneless skinless chicken breast halves\n- 1 cup barbecue sauce\n- 1 tube pizza crust\n- 2 teaspoons olive oil\n- 2 cups shredded Gouda cheese\n- 1 small red onion\n- 1/4 cup minced fresh cilantro",
                "So fast and so easy with refrigerated pizza crust, these saucy, smoky pizzas make quick fans with their hot-off-the-grill, rustic flavor.",
                "STEP 1:\nSprinkle chicken with pepper, grill with barbecue sauce.\n\nSTEP 2:\nPress dough into rectangle, grill until browned.\n\nSTEP 3:\nSpread sauce, top with cheese, chicken and onion. Grill 2-3 minutes."));

        data.add(new Produit("BRUSCHETTA PIZZA", 5.0,
                R.mipmap.pizza2, "35 min",
                "- 1/2 pound pork sausage\n- 1 prebaked pizza crust\n- 1 package turkey pepperoni\n- 2 cups mozzarella cheese\n- 1-1/2 cups chopped tomatoes\n- 1/2 cup fresh basil\n- 1 tablespoon olive oil\n- 2 garlic cloves",
                "Loaded with Italian flavor and plenty of fresh tomatoes, it's bound to become a family favorite.",
                "STEP 1:\nCook sausage, place on crust with pepperoni and cheese. Bake 450 degrees 10-12 min.\n\nSTEP 2:\nCombine tomatoes, basil, oil, garlic. Spoon over pizza."));

        data.add(new Produit("SPINACH PIZZA", 2.0,
                R.mipmap.pizza3, "25 min",
                "- 1 package pizza crust mix\n- 1/2 cup Alfredo sauce\n- 2 medium tomatoes\n- 4 cups fresh spinach\n- 2 cups Italian cheese blend",
                "This tasty pizza is so easy to prepare. My family loves it. A great way to make a veggie-filled meal!",
                "STEP 1:\nPrepare pizza dough, press onto greased pan.\n\nSTEP 2:\nSpread Alfredo sauce over dough.\n\nSTEP 3:\nTop with spinach, tomatoes and cheese. Bake 450 degrees 10-15 min."));

        data.add(new Produit("DEEP-DISH SAUSAGE PIZZA", 8.0,
                R.mipmap.pizza4, "45 min",
                "- 1 package active dry yeast\n- 2/3 cup warm water\n- 1-3/4 cups flour\n- 1/4 cup vegetable oil\n- Oregano, basil, marjoram\n- Garlic salt, onion salt",
                "My Grandma made the tastiest pizza on her farm. Covered with cheese and fragrant herbs in the crust.",
                "STEP 1:\nDissolve yeast, mix flour and seasonings. Knead dough 6-8 min. Let rise 1 hour.\n\nSTEP 2:\nLayer toppings on crust.\n\nSTEP 3:\nBake 400 degrees 20 min, then add pepperoni and bake 10-15 min more."));

        data.add(new Produit("HOMEMADE PIZZA", 4.0,
                R.mipmap.pizza5, "50 min",
                "- 1 package active dry yeast\n- 1-1/4 cups warm water\n- 1/4 cup canola oil\n- 3-1/2 cups flour\n- 1/2 pound ground beef\n- 1 small onion\n- Tomato sauce, mozzarella cheese",
                "A hearty, zesty main dish with a crisp golden crust. Use whatever toppings your family enjoys.",
                "STEP 1:\nDissolve yeast, add oil and flour. Let dough rise 45 min.\n\nSTEP 2:\nCook beef and onion.\n\nSTEP 3:\nPress dough onto pans, add sauce and toppings.\n\nSTEP 4:\nBake 400 degrees 25-30 min."));

        data.add(new Produit("PESTO CHICKEN PIZZA", 3.0,
                R.mipmap.pizza6, "50 min",
                "- 2 teaspoons active dry yeast\n- 2-3/4 cups bread flour\n- 1/2 pound chicken breast\n- Peppers, mushrooms, onion\n- 3 tablespoons prepared pesto\n- 1-1/2 cups mozzarella cheese",
                "This is the only pizza I make now. Keeping spices simple helps the flavors of chicken and vegetables come through.",
                "STEP 1:\nMake dough, let rise 1 hour.\n\nSTEP 2:\nCook chicken with vegetables.\n\nSTEP 3:\nSpread pesto on dough, top with chicken mixture and cheese.\n\nSTEP 4:\nBake 400 degrees 18-20 min."));

        data.add(new Produit("LOADED MEXICAN PIZZA", 3.0,
                R.mipmap.pizza7, "30 min",
                "- 1 can black beans\n- 1 red onion chopped\n- Chili powder, cumin\n- 3 tomatoes chopped\n- 1 jalapeno pepper\n- Fresh spinach\n- Cheddar and pepper jack cheese",
                "My husband is a picky eater but this healthy pizza has lots of flavor. Leftovers taste even better the next day!",
                "STEP 1:\nMash black beans with onion and spices.\n\nSTEP 2:\nSpread on crust, top with tomatoes and spinach.\n\nSTEP 3:\nSprinkle cheeses, bake 400 degrees 12-15 min."));

        data.add(new Produit("BACON CHEESEBURGER PIZZA", 2.0,
                R.mipmap.pizza8, "20 min",
                "- 1/2 pound ground beef\n- 1 small onion\n- Pizza sauce\n- 6 bacon strips cooked\n- 20 dill pickle slices\n- Mozzarella and cheddar cheese",
                "Kids of all ages love pizza and cheeseburgers, and this recipe combines them both!",
                "STEP 1:\nCook beef and onion, drain.\n\nSTEP 2:\nPlace on crust with pizza sauce, bacon, pickles and cheeses.\n\nSTEP 3:\nBake 450 degrees 8-10 min until cheese melts."));

        data.add(new Produit("PIZZA MARGHERITA", 1.0,
                R.mipmap.pizza9, "30 min",
                "- 3 teaspoons active dry yeast\n- 1 cup warm water\n- 2 tablespoons olive oil\n- 1 teaspoon sugar and salt\n- 3 cups bread flour\n- Fresh basil and mozzarella",
                "A classic Pizza Margherita named for Queen Margherita of Italy, showing off the colors of the Italian flag.",
                "STEP 1:\nDissolve yeast, add oil sugar salt and flour. Knead 6-8 min.\n\nSTEP 2:\nLet rise 1 hour, divide in half.\n\nSTEP 3:\nTop with tomatoes, basil, cheese. Bake 450 degrees 15-20 min."));

        data.add(new Produit("PEPPERONI-SAUSAGE STUFFED PIZZA", 5.0,
                R.mipmap.pizza10, "45 min",
                "- 1 package active dry yeast\n- 3-1/2 cups flour\n- Sausage cooked and crumbled\n- Pepperoni slices\n- Mozzarella and cheddar cheese\n- Pizza sauce",
                "For 30 years, friends have been telling me to open a pizzeria using this recipe. It even freezes well!",
                "STEP 1:\nMake dough, let rise 1 hour.\n\nSTEP 2:\nPress dough into pan, layer with cheeses and toppings.\n\nSTEP 3:\nCover with remaining dough, bake 425 degrees 10 min.\n\nSTEP 4:\nReduce to 375, spread pizza sauce, bake 30-35 min more."));
    }

    @Override
    public Produit create(Produit p) { data.add(p); return p; }

    @Override
    public Produit update(Produit p) {
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).getId() == p.getId()) {
                data.set(i, p);
                return p;
            }
        }
        return null;
    }

    @Override
    public boolean delete(long id) {
        return data.removeIf(x -> x.getId() == id);
    }

    @Override
    public Produit findById(long id) {
        for (Produit p : data)
            if (p.getId() == id) return p;
        return null;
    }

    @Override
    public List<Produit> findAll() {
        return Collections.unmodifiableList(data);
    }
}