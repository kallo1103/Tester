describe('Login Functionality', () => {
    beforeEach(() => {
        cy.visit('https://www.saucedemo.com');
    });

    it('Should display login page elements correctly', () => {
        cy.get('.login_logo').should('be.visible').and('contain', 'Swag Labs');
        cy.get('#user-name').should('be.visible').and('have.attr', 'placeholder', 'Username');
        cy.get('#password').should('be.visible').and('have.attr', 'placeholder', 'Password');
        cy.get('#login-button').should('be.visible').and('have.value', 'Login');
    });

    it('Should login successfully with valid credentials', () => {
        cy.get('#user-name').type('standard_user');
        cy.get('#password').type('secret_sauce');
        cy.get('#login-button').click();

        // Assert URL and Title
        cy.url().should('include', '/inventory.html');
        cy.get('.title').should('have.text', 'Products');
        // Ensure the cart icon is visible
        cy.get('.shopping_cart_link').should('be.visible');
    });

    it('Should show error message with invalid username', () => {
        cy.get('#user-name').type('invalid_user');
        cy.get('#password').type('secret_sauce');
        cy.get('#login-button').click();
        cy.get('.error-message-container').should('be.visible').and('contain', 'Username and password do not match');
    });

    it('Should show error message with invalid password', () => {
        cy.get('#user-name').type('standard_user');
        cy.get('#password').type('wrong_password');
        cy.get('#login-button').click();
        cy.get('.error-message-container').should('be.visible').and('contain', 'Username and password do not match');
    });

    it('Should show locked out error for locked_out_user', () => {
        cy.get('#user-name').type('locked_out_user');
        cy.get('#password').type('secret_sauce');
        cy.get('#login-button').click();
        cy.get('.error-message-container').should('be.visible').and('contain', 'Sorry, this user has been locked out.');
    });

    it('Should logout successfully', () => {
        // Login first
        cy.get('#user-name').type('standard_user');
        cy.get('#password').type('secret_sauce');
        cy.get('#login-button').click();

        // Open side menu
        cy.get('#react-burger-menu-btn').click();
        // Wait for animation or visibility
        cy.get('#logout_sidebar_link').should('be.visible').click();

        // Verify redirected to login page
        cy.url().should('eq', 'https://www.saucedemo.com/');
        cy.get('#login-button').should('be.visible');
    });
});
