# (IAA) Interest Accrued Annually
Most of the time, we deal with interest that accrues annually. 
This is the way most people seem to think about interest ? it?s easy to understand and works in most situations.
Let?s stop for a moment and talk about what accrue means. 
When interest accrues, it means that the bank calculates how much interest you owe (or are owed) and applies that to your balance.

For example, let?s say you had a $100,000 debt with a 12% interest rate. 
If the interest is accrued annually, the calculation is really easy. 
You just multiply the amount ? $100,000 ? by the interest rate ? 12% (which you?d type into a calculator as 0.12) ? and that gives you $12,000 in new interest, giving you a new balance of $112,000.

## (APR) Annual Percentage Rate
Annual Percentage Rate (APR) is a measure that attempts to calculate what percentage of the principal you?ll pay per time period (in this case a year), taking every charge ? monthly payments over the course of the loan, upfront fees, etc. ? into account.
By the way, the Alpha Mortgage loan in the example above carries the lower APR. With the Beta Mortgage loan, you?re essentially paying $3,000 for the privilege of borrowing $100,000, and thus effectively borrowing only $97,000. However, you?re still making interest payments that the lender is basing on a $100,000 loan, not a $97,000 one. A lower denominator has the same effect as a higher numerator. The APR on the Alpha Mortgage loan is 5.00%, but the APR on the Beta Mortgage loan is 5.02%.
To calculate the APR for a loan that incorporates costs beyond those of the principal borrowed, first determine how much the periodic payments are. For the Beta Mortgage loan, each monthly payment is:

![APR Caclulation](http://i.investopedia.com/apr1.png)

The $100,000 is the gross principal borrowed, .0475 the interest rate, 12 the number of periods in a year, and 360 the number of periods over the course of the loan. Break out your calculator, and you?ll find that the monthly payment is $521.65.
Then, divide the monthly payment into the net amount you?re borrowing,

![Division](http://i.investopedia.com/apr2_0.png)

The APR is the unknown quantity that solves this equation:

![unknown quantity](http://i.investopedia.com/apr3_0.png)

Which, alas, you can?t figure out through any amount of algebraic manipulation. You need either a fondness for trial-and-error and an awful lot of patience, or a computer. [In Microsoft Excel, the formula is ?RATE (nper, pmt, pv, fv, type, guess).' Use 360; -521.65 (rounded); and for the first three values, respectively]. Multiply by 12 to get the annual rate. The resulting rate is 5.02%.

## (APY) Annual Percentage Yield
  
With interest that accrues annually, there is no difference between APR and APY. 
It only matters when interest accrues more frequently than that, as we?ll see below.

# Interest Accrued Daily and Continuously
Some banks will accrue interest daily. Some even accrue it continuously. 
Rest assured, the more often a bank accrues interest on your debt, the worse it is for you (on the other hand, the more often a bank accrues interest on your savings account, the better it is for you).

So, let?s look again at the $100,000 loan at 12% APR.
If interest is being accrued daily? you better break out the spreadsheet. 
You?ll need to divide 12% by 365, giving you 0.032876712% calculated each day. 
Then, you have to do the calculation described above 365 times. 

I?ll save you the trouble ? if interest is accrued daily, you?ll end up with a balance of $112,747.46. 
This debt would have an APY of 12.74746%, in other words.

What about constant accruing? 
It uses a mathematical formula that essentially breaks the time slices down even further until the time slices approach zero (here?s a brief explanation if you want to dip your toes into the math). 
If you use that method, the balance is $112,749.69, or a 12.74969% APY.

# Daily Accrual Example
Consider a $100,000 mortgage loan with a 15% APR accrued daily. Assuming the contract has a 365-day year, as some are 360, the daily interest rate can be found by dividing 15% by 365. This calculation yields a daily interest rate of 0.0410958%.
The accrued interest on the first day of the mortgage is equal to $100,000 x 0.0410958%, or $41.0958. The account balance on day two equals $100,041.10 after rounding. Moving beyond day two, interest accrual depends on the compounding period.

# Compounding Interest
Accrual and compounding periods are often different. Compounding changes the account balance from which the accrual calculations take place. If interest compounds monthly, then every month has a "compound date" where past accrued interest is summed and becomes the new base balance.
Take the previous $100,000 mortgage example. Under monthly compounding, the daily accrual amount, $41.0958, is the same for each day in the first month. On the compound date, all of the total accrued interest to that point is added to a new base amount. Every day in the second month uses the new, compounded loan balance.
Compounding can also take place daily or annually. Generally speaking, debtors are better off with less frequent accrual and compounding periods, while savers are better off with more frequent periods.
