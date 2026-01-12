describe('Cart and Product Management', () => {
    beforeEach(() => {
        cy.visit('https://www.saucedemo.com');
        cy.get('#user-name').type('standard_user');
        cy.get('#password').type('secret_sauce');
        cy.get('#login-button').click();
    });

    it('Should sort products by Price (low to high)', () => {
        cy.get('.product_sort_container').select('lohi');

        // Check first item price
        cy.get('.inventory_item_price').first().invoke('text').then((text) => {
            expect(text).to.equal('$7.99'); // Known lowest price item "Sauce Labs Onesie"
        });

        // Check last item price
        cy.get('.inventory_item_price').last().invoke('text').then((text) => {
            expect(text).to.equal('$49.99'); // Known highest price item "Sauce Labs Fleece Jacket"
        });
    });

    it('Should sort products by Name (Z to A)', () => {
        cy.get('.product_sort_container').select('za');
        cy.get('.inventory_item_name').first().should('contain', 'Test.allTheThings() T-Shirt (Red)');
    });

    it('Should add a product to the cart and verify button state', () => {
        // Target the first product: Sauce Labs Backpack
        cy.get('.inventory_item').first().as('firstProduct');

        // Verify initial button text
        cy.get('@firstProduct').find('.btn_inventory').should('have.text', 'Add to cart');

        // Add to cart
        cy.get('@firstProduct').find('.btn_inventory').click();

        // Verify button text changes to Remove
        cy.get('@firstProduct').find('.btn_inventory').should('have.text', 'Remove');
        cy.get('@firstProduct').find('.btn_inventory').should('have.class', 'btn_secondary');

        // Verify Cart Badge
        cy.get('.shopping_cart_badge').should('be.visible').and('have.text', '1');
    });

    it('Should remove a product from the cart via Inventory page', () => {
        // Add product
        cy.get('.inventory_item').first().find('.btn_inventory').click();
        cy.get('.shopping_cart_badge').should('have.text', '1');

        // Remove product
        cy.get('.inventory_item').first().find('.btn_inventory').click();

        // Verify button reverts
        cy.get('.inventory_item').first().find('.btn_inventory').should('have.text', 'Add to cart');

        // Verify badge removal
        cy.get('.shopping_cart_badge').should('not.exist');
    });

    it('Should remove a product from the Cart page', () => {
        // Add product "Sauce Labs Backpack"
        cy.get('#add-to-cart-sauce-labs-backpack').click();

        // Navigate to Cart
        cy.get('.shopping_cart_link').click();
        cy.url().should('include', '/cart.html');

        // Verify item is in cart list
        cy.get('.cart_item').should('have.length', 1);
        cy.get('.inventory_item_name').should('have.text', 'Sauce Labs Backpack');

        // Click Remove
        cy.get('#remove-sauce-labs-backpack').click();

        // Verify item is removed from view
        cy.get('.cart_item').should('not.exist');
        cy.get('.shopping_cart_badge').should('not.exist');
    });
});
