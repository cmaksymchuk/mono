
ActiveRecord::Schema[7.0].define(version: 2022_06_13_021433) do
  create_table "friends", force: :cascade do |t|
    t.string "first_name"
    t.string "last_name"
    t.string "phone"
    t.string "email"
    t.string "twitter"
    t.datetime "created_at", null: false
    t.datetime "updated_at", null: false
  end

end
