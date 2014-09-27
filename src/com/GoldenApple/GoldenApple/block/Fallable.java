
use pocketmine\item\Item;
use pocketmine\Player;
use pocketmine\level\Level;
use pocketmine\entity\FallingBlock;
use pocketmine\nbt\tag\Compound;
use pocketmine\nbt\tag\Enum;
use pocketmine\nbt\tag\Double;
use pocketmine\nbt\tag\Float;
use pocketmine\nbt\tag\Byte;

class Fallable extends Solid{

	public $hasPhysics = true;

	public function place(Item $item, Block $block, Block $target, $face, $fx, $fy, $fz, Player $player = null){
		$ret = $this->getLevel()->setBlock($this, $this, true, true);

		return $ret;
	}

	public function onUpdate($type){
		if($this->hasPhysics === true and $type === Level::BLOCK_UPDATE_NORMAL){
			$down = $this->getSide(0);
			if($down->getID() === self::AIR or ($down instanceof Liquid)){
				$fall = new FallingBlock($this->getLevel()->getChunk($this->x >> 4, $this->z >> 4), new Compound("", [
					"Pos" => new Enum("Pos", [
						new Double("", $this->x + 0.5),
						new Double("", $this->y + 0.5),
						new Double("", $this->z + 0.5)
					]),
					//TODO: add random motion with physics
					"Motion" => new Enum("Motion", [
						new Double("", 0),
						new Double("", 0),
						new Double("", 0)
					]),
					"Rotation" => new Enum("Rotation", [
						new Float("", 0),
						new Float("", 0)
					]),
					"Tile" => new Byte("Tile", $this->getID())
				]));

				$fall->spawnToAll();
			}

			return false;
		}
	}
}