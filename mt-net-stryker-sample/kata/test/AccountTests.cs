using System;
using FluentAssertions;
using kata.main;
using Xunit;

namespace kata.test
{
    public class AccountTest
    {
        [Fact]
        public void Should_create_new_account()
        {
            //Arrange
            const string owner = "Jack";

            //Act
            var account = new Account(owner);

            //Assert
            account.Balance.Should().Be(default);
            account.Overdraft.Should().Be(default);
            account.Id.Should().NotBe(default(Guid));
            account.Owner.Should().Be(owner);
        }

        [Fact]
        public void Should_enable_overdraft()
        {
            //Arrange
            var account = new AccountBuilder().Build();

            //Act
            account.EnableOverdraft();

            //Assert
            account.Overdraft.Should().Be(true);
        }

        [Fact]
        public void Should_disable_overdraft()
        {
            //Arrange
            var account = new AccountBuilder()
                .WithOverdraft()
                .Build();

            //Act
            account.DisableOverdraft();

            //Assert
            account.Overdraft.Should().Be(account.Overdraft);
        }

        [Fact]
        public void Should_add_to_account()
        {
            //Arrange
            const int amountToAdd = 500;

            var account = new AccountBuilder().Build();

            //Act
            account.AddMoney(amountToAdd);

            //Assert
            account.Balance.Should().Be(amountToAdd);
        }

        [Fact]
        public void Should_withdrawn_from_account_with_overdraft()
        {
            //Arrange
            const int initialBalance = 200;
            const int amountToWithdrawn = 350;

            var account = new AccountBuilder()
                .WithOverdraft()
                .WithInitialAmount(initialBalance)
                .Build();

            //Act
            account.WithdrawMoney(amountToWithdrawn);

            //Assert
            account.Balance.Should().Be(initialBalance - amountToWithdrawn);
        }

        [Fact]
        public void Should_withdrawn_from_account_without_overdraft()
        {
            //Arrange
            const int initialBalance = 500;
            const int amountToWithdrawn = 350;

            var account = new AccountBuilder()
                .WithInitialAmount(initialBalance)
                .Build();

            //Act
            account.WithdrawMoney(amountToWithdrawn);

            //Assert
            account.Balance.Should().Be(initialBalance - amountToWithdrawn);
        }
    }
}