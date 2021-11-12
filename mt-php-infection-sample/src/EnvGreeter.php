<?php

namespace App;

final class EnvGreeter extends Greeter
{
    public function greetFromEnv(string $environmentVariableName): string
    {
        $name = getenv($environmentVariableName);
        return $this->greet($name);
    }
}
