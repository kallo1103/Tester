describe('Full Checkout Flow', () => {
    beforeEach(() => {
        cy.visit('https://www.saucedemo.com');
        cy.get('#user-name').type('standard_user');
        cy.get('#password').type('secret_sauce');
        cy.get('#login-button').click();

        // Ensure cart is empty before starting (though standard_user usually starts fresh, it's good practice)
        // Here we assume session reset or fresh user state
    });

    it('Should complete a successful checkout with two items', () => {
        // 1. Add two items
        cy.get('#add-to-cart-sauce-labs-backpack').click();
        cy.get('#add-to-cart-sauce-labs-bike-light').click();

        cy.get('.shopping_cart_badge').should('have.text', '2');

        // 2. Go to Cart
        cy.get('.shopping_cart_link').click();
        cy.url().should('include', '/cart.html');

        // Verify items
        cy.get('.inventory_item_name').eq(0).should('contain', 'Sauce Labs Backpack');
        cy.get('.inventory_item_name').eq(1).should('contain', 'Sauce Labs Bike Light');

        // 3. Checkout Step 1
        cy.get('#checkout').click();
        cy.url().should('include', '/checkout-step-one.html');

        // Fill form
        cy.get('#first-name').type('Test');
        cy.get('#last-name').type('User');
        cy.get('#postal-code').type('12345');
        cy.get('#continue').click();

        // 4. Checkout Step 2 (Overview)
        cy.url().should('include', '/checkout-step-two.html');

        // Verify Subtotal (29.99 + 9.99 = 39.98)
        cy.get('.summary_subtotal_label').should('contain', '39.98');

        // 5. Finish
        cy.get('#finish').click();

        // 6. Verify Completion
        cy.url().should('include', '/checkout-complete.html');
        cy.get('.complete-header').should('have.text', 'Thank you for your order!');
        cy.get('.complete-text').should('contain', 'Your order has been dispatched');

        // 7. Back home
        cy.get('#back-to-products').click();
        cy.url().should('include', '/inventory.html');
        cy.get('.shopping_cart_badge').should('not.exist'); // Cart should be empty
    });

    it('Should validate checkout information form', () => {
        cy.get('#add-to-cart-sauce-labs-onesie').click();
        cy.get('.shopping_cart_link').click();
        cy.get('#checkout').click();

        // Try to continue without filling info
        cy.get('#continue').click();
        cy.get('.error-message-container').should('be.visible').and('contain', 'Error: First Name is required');

        // Fill Name only
        cy.get('#first-name').type('John');
        cy.get('#continue').click();
        cy.get('.error-message-container').should('contain', 'Error: Last Name is required');
    });
});
