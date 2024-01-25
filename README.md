

# Launchpads Plugin for Minecraft

## Overview

Launchpads is a Bukkit plugin for Minecraft that allows players to create launchpads using a configurable block. When players step on the specified material (slime by default), they will be launched into the air at a customizable height and distance.

## Features

- Launch players into the air when they step on the specified material block.
- Configurable launch height and distance.
- Support for multiple worlds.

## Installation

1. Download the latest JAR file from the [Releases](https://github.com/lucolvin/Launchpads/releases) section.
2. Place the JAR file into the `plugins` folder of your Bukkit/Spigot server.
3. Start or restart your server.

## Configuration

The plugin comes with a configuration file (`config.yml`) where you can customize various settings.

- `material`: The material that triggers the launchpad effect.
- `height`: The height at which players will be launched.
- `distance`: The horizontal distance of the launch.
- `enabledWorlds`: A list of worlds where the launchpad effect is enabled.

To reload the configuration in-game, use the command `/launchpads-reload` (requires the `lps.reload` permission).

## Commands

- `/launchpads`: Displays plugin information.
- `/launchpads-reload`: Reloads the plugin configuration (requires `lps.reload` permission).

## Permissions

- `lps.reload`: Allows a player to reload the plugin configuration.

## Usage

1. Place configured blocks in your world.
2. Configure the material, height, and distance in the `config.yml` file.
3. Players will be launched when they step on the configured material block.

## Credits

- Plugin Developer: PhoenixL3ader

## Support

For any issues or questions, please create an [issue](https://github.com/lucolvin/Launchpads/issues) on the GitHub repository.

---
