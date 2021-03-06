<?php

// Calculator.php
final class Calculator
{
    public function divideBy($num2)
    {
        if ($num2 == 0)
        {
            return NAN;
        }
        return $this->getNumberFromUserInput() / $num2;
    }

    public function getNumberFromUserInput()
    {
        // complicated function to get number from user input
    }

    public function divideByAndPrint($num2)
    {
        if ($num2 == 0)
        {
            $this->printToScreen("NaN");
        }
        $this->printToScreen($this->getNumberFromUserInput() / $num2);
    }

    public function printToScreen($value)
    {
        // another complicated function
    }
}
