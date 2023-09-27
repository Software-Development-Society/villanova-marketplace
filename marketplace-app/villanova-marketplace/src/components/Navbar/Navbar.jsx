import React, { useState } from 'react';
import styled from 'styled-components';

const NavbarContainer = styled.div`
  background: #333;
  height: 100px;
  position: fixed;
  top: 0;
  left: 0;
  right: 0;
  display: flex;
  align-items: center;
  justify-content: space-between;
  padding: 0 20px;
  color: white;
`;

const Logo = styled.div`
  font-size: 24px;
  font-weight: bold;
`;

const NavLinks = styled.div`
  display: flex;
  gap: 20px;
  align-items: center;

  @media (max-width: 768px) {
    display: none;
  }
`;

const NavLink = styled.a`
  color: white;
  text-decoration: none;
  font-weight: bold;
  transition: color 0.3s;

  &:hover {
    color: #FF00FF; /* Change color on hover */
  }
`;

const MobileMenuButton = styled.div`
  display: none;
  cursor: pointer;

  @media (max-width: 768px) {
    display: block;
  }
`;

const MobileMenu = styled.div`
  display: ${(props) => (props.isOpen ? 'block' : 'none')};
  position: absolute;
  top: 100px;
  right: 20px;
  background: #333;
  padding: 10px;
  border-radius: 5px;

  @media (max-width: 768px) {
    display: block;
  }

  &:hover {
    color: #FF00FF; /* Change color on hover */
  }
`;

const MobileMenuItem = styled.a`
  display: block;
  color: white;
  text-decoration: none;
  font-weight: bold;
  margin-bottom: 10px;
`;

const Navbar = () => {
  const [isMobileMenuOpen, setMobileMenuOpen] = useState(false);
  const [isLoggedIn, setIsLoggedIn] = useState(true); // Add this line

  const toggleMobileMenu = () => {
    setMobileMenuOpen(!isMobileMenuOpen);
  };

  return (
    <NavbarContainer>
      <Logo>Villanova Marketplace</Logo>
      <NavLinks>
        {isLoggedIn ? (
          <>
            <NavLink href="/">Home</NavLink>
            <NavLink href="/about">About</NavLink>
            <NavLink href="/sell">Sell</NavLink>
            <NavLink href="/logout">Logout</NavLink>
          </>
        ) : (
          <NavLink href="/login">Login</NavLink>
        )}
      </NavLinks>
      <MobileMenuButton onClick={toggleMobileMenu}>☰</MobileMenuButton>
      <MobileMenu isOpen={isMobileMenuOpen}>
        {isLoggedIn ? (
          <>
            <MobileMenuItem href="/">Home</MobileMenuItem>
            <MobileMenuItem href="/about">About</MobileMenuItem>
            <MobileMenuItem href="/sell">Sell</MobileMenuItem>
            <MobileMenuItem href="/logout">Logout</MobileMenuItem>
          </>
        ) : (
          <MobileMenuItem href="/login">Login</MobileMenuItem>
        )}
      </MobileMenu>
    </NavbarContainer>
  );
};

export default Navbar;
